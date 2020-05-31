//存放交互逻辑
//javascript模块化
var seckill = {
    //封装秒杀相关ajax的地址
    URL : {
        now : function () {
            return '/seckill/time/now';
        },
        exposer : function (seckillId) {
            return '/seckill/' + seckillId + '/exposer';
        },
        execution : function (seckillId, md5) {
            return '/seckill/'+seckillId+'/'+md5+'/execution';
        }
    },
    handleSeckillkill : function(seckillId, node){
        node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
        $.post(seckill.URL.exposer(seckillId),{}, function (result) {
            //回调函数中,执行交互流程
            if(result && result['success']){
                var exposer = result['data'];
                if(exposer['exposed']){
                    //开启秒杀
                    var md5 = exposer['md5'];
                    var killUrl = seckill.URL.execution(seckillId, md5);
                    console.log("killUrl:"+killUrl);
                    $('#killBtn').one('click', function () {
                        //绑定按钮
                        //禁用按钮
                        $(this).addClass('disabled');
                        //发送秒杀请求
                        $.post(killUrl, {}, function (result) {
                            console.log('result:'+result);
                            if(result && result['success']){
                                var killResult = result['data'];
                                var state = killResult['state'];
                                var stateInfo = killResult['stateInfo'];
                                //显示秒杀结果
                                node.html('<span class="label label-success">'+ stateInfo +'</span>');
                            }
                        });
                    });
                    node.show();
                }else{
                    //未开启秒杀
                    var now = exposer['now'];
                    var start = exposer['start'];
                    var end = exposer['end'];
                    //重新计算计时逻辑
                    seckill.countdown(seckillId, now, start, end);
                }
            }else{
                console.log('result'+result);
            }
        });
    },
    //验证手机号
    validatePhone: function(phone){
        if(phone && phone.length == 11 && !isNaN(phone)){
            return true;
        }else{
            return false;
        }
    },
    countdown : function(seckillId, nowTime, startTime, endTime){
        var seckillBox = $('#seckill-box');
        //时间判断
        if(nowTime > endTime){
            //秒杀结束
            seckillBox.html('秒杀结束！');
        }else if(nowTime < startTime){
            //秒杀未开始
            var killTime = new Date(startTime + 1000);
            seckillBox.countdown(killTime, function (event) {
                //时间格式
                var format = event.strftime('秒杀倒计时: %D天 %H时 %M分 %S秒');
                seckillBox.html(format);
            }).on('finish.countdown', function () {
                //获取秒杀地址 实现显示逻辑， 执行秒杀
                seckill.handleSeckillkill(seckillId, seckillBox);
            });
        }else{
            //秒杀开始
            seckill.handleSeckillkill(seckillId, seckillBox);
        }
    },
    detail: {
        //初始化
        init: function (params) {
            //手机验证和登录， 计时交互
            //cookie中的数据
            var killPhone = $.cookie('killPhone');
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['seckillId'];
            //验证手机号
            if(!seckill.validatePhone(killPhone)){
                //绑定phone
                var killPhoneModal = $('#killPhoneModal');
                killPhoneModal.modal({
                    //显示弹出层
                    show : true,
                    backdrop : 'static',
                    keyboard : false
                });
                $('#killPhoneBtn').click(function () {
                   var inputPhone = $('#killPhoneKey').val();
                   //console.log('inputphone='+inputPhone);
                   if(seckill.validatePhone(inputPhone)){
                       //电话写入cookie
                       $.cookie('killPhone', inputPhone, {expires:7,path:'/seckill'});
                       //刷新页面
                       window.location.reload();
                   }else{
                       $('#killPhoneMessage').hide().html('<lable class="label label-danger">手机号错误</lable>').show(300);
                   }
                });
            }
            //验证成功
            $.get(seckill.URL.now(), {}, function (result) {
                if(result && result['success']){
                    var nowTime = result['data'];
                    //时间判断，计时服务
                    seckill.countdown(seckillId, nowTime, startTime, endTime);
                }else{
                    console.log('result:'+result)
                }
            });
        }
    }
}