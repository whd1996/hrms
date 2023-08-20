$(function () {
    //获取cookies   并用冒号分割
    //console.log(getCookie("userlogininfo"));
    if (getCookie("userlogininfo") != null && getCookie("userlogininfo") != "") {
        var userlogininfo = getCookie("userlogininfo").split(":");
        var data = JSON.stringify(userlogininfo);
        if (data != '[""]') {
            $("#user_account").val(userlogininfo[0]);
            $("#user_password").val(userlogininfo[1]);
            //$("input[id='rememberMe']:checked").attr("checked",true);//这个选中值 但页面不会改变
            $("input[type='checkbox']").prop({checked: true});//这个选中值 但页面不会改变
        }

    }
    // Waves初始化
    Waves.displayEffect();
    // 输入框获取焦点后出现下划线
    $('.form-control').focus(function () {
        $(this).parent().addClass('fg-toggled');
    }).blur(function () {
        $(this).parent().removeClass('fg-toggled');
    });
});
Checkbix.init();
$(function () {
    // 点击登录按钮
    $('#login-bt').click(function () {
        login();
    });
    // 回车事件
    $('#user_account, #user_password').keypress(function (event) {
        if (13 == event.keyCode) {
            login();
        }
    });
});

//读 cookies;
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr === document.cookie.match(reg)) return unescape(arr[2]); else return null;
}

// 登录
function login() {
    let code = $("#captcha").val();
    let flag = true;
    $.ajax({
        type: "get", url: "/hrms/verify?code=" + code, async: false, success: function (data) {
            if (data !== "验证码正确") {
                // $("#captchaGif").load(location.href+" #captchaGif");//局部刷新验证码
                $("#imgControl").click();
                $("#captcha").attr("placeholder", data);   //处理get返回结果
                flag = false;
            }
        }
    });
    if (flag === false) return false;
    var user = {};
    user.user_account = $("#user_account").val();
    user.user_password = $("#user_password").val();
    user.id = $("input[id='rememberMe']:checked").val();//这里没用到id  我借用一下用作实现记住密码功能
    $.ajax({
        type: "POST",
        url: "/hrms/user/login",
        async: false,
        contentType: "application/json",
        data: JSON.stringify(user),
        success: function (result) {
            console.log(result);
            if (result["msg"] != "登录失败") {
                if (result["msg"] == "总经理登录成功") {
                    alert("总经理,欢迎您使用本系统!");
                } else if (result["msg"] == "经理登录成功") {
                    if (result["department"] != "人事部") {
                        alert(result["department"] + "部门经理,您无权限使用该系统！!");
                        return false;
                    }
                    alert(result["department"] + "部门经理,登录成功!");
                } else if (result["msg"] == "主管登录成功") {
                    if (result["department"] != "人事部") alert(result["department"] + "部门主管,您无权限使用该系统！!"); else alert(result["department"] + "部门主管,登录成功!");
                } else if (result["msg"] == "员工登录成功") {
                    if (result["department"] != "人事部") {
                        alert(result["department"] + "的员工,您无权限使用该系统！!");
                        return false;
                    } else alert(result["department"] + "的员工" + result["user_account"] + ",登录成功!");
                }
                sessionStorage.setItem("userRole", result["role"]);
                sessionStorage.setItem("userDepartment", result["department"]);
                sessionStorage.setItem("user_account", result["user_account"]);
                $(location).attr('href', '/hrms/index.html');
            } else {
                //alert("用户名或密码错误！");
                $("#imgControl").click();
                $("#user_account").attr("placeholder", "用户名或密码错误");
            }

        }

    });
}