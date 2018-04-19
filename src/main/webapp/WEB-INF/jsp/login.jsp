<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <title></title>
    <!-- 부트스트랩 -->
    <!--<link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">-->
    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
 <!--===============================================================================================-->
	<link rel="icon" type="image/png" href="https://colorlib.com/etc/lf/Login_v15/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/lf/Login_v15/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/lf/Login_v15/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/lf/Login_v15/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/lf/Login_v15/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/lf/Login_v15/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/lf/Login_v15/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/lf/Login_v15/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/lf/Login_v15/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/lf/Login_v15/css/util.css">
	<link rel="stylesheet" type="text/css" href="https://colorlib.com/etc/lf/Login_v15/css/main.css">
<!--===============================================================================================-->

  </head>
  <body>
 	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title" style="background-image: url(https://colorlib.com/etc/lf/Login_v15/images/bg-01.jpg);">
					<span class="login100-form-title-1">
					</span>
				</div>
				<form class="login100-form validate-form" action="/loginCheck" method="post">
					<div class="wrap-input100 validate-input m-b-26" data-validate="아이디를 입력하세요">
						<span class="label-input100">아이디</span>
						<input class="input100" type="text" name="staffId" id="staffId" placeholder="아이디">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-18" data-validate = "비밀번호">
						<span class="label-input100">비밀번호</span>
						<input class="input100" type="password" name="staffPwd"  id="staffPwd" placeholder="비밀번호를 입력하세요">
						<span class="focus-input100"></span>
					</div>

					<div class="flex-sb-m w-full p-b-30">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								자동로그인
							</label>
						</div>

						<div>
							<a href="#" class="txt1">
								비밀번호를 모르나요?
							</a>
						</div>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" >
							Login
						</button>
						<label class="login100-form-btn" onclick="funAjax1()">
							Test1
						</label>
						<label class="login100-form-btn" onclick="funAjax2()">
							Test2
						</label>
					</div>
				</form>
			</div>
		</div>
	</div>

<!--===============================================================================================-->
	<script src="https://colorlib.com/etc/lf/Login_v15/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="https://colorlib.com/etc/lf/Login_v15/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="https://colorlib.com/etc/lf/Login_v15/vendor/bootstrap/js/popper.js"></script>
	<script src="https://colorlib.com/etc/lf/Login_v15/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="https://colorlib.com/etc/lf/Login_v15/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="https://colorlib.com/etc/lf/Login_v15/vendor/daterangepicker/moment.min.js"></script>
	<script src="https://colorlib.com/etc/lf/Login_v15/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="https://colorlib.com/etc/lf/Login_v15/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="https://colorlib.com/etc/lf/Login_v15/js/main.js"></script>
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
	<script>
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());

	  gtag('config', 'UA-23581568-13');
	</script>
	
	<script type="text/javascript">
		function funAjax1(){
			 $.ajax({ 
		            url : 'http://localhost:8080/users/user', 
		            type: 'POST',
		            dataType: 'json',
		            crossDomain: true,
		            //contentType: "application/json; charset=utf-8",
		            cache: false,
		              headers: {
		                'Authorization':'Bearer ' + JSON.parse(localStorage.getItem("ls.token")).access_token ,
		                'Content-Type':'application/json;charset=utf-8;',
		                'Access-Control-Allow-Origin':'*'
		            }, 		
		            data: "",
		            success : function(response) {
		            		 alert(JSON.stringify(response));
		            },
		               error:function(request,status,error){
		                   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		                  } 
		        });
		}
		function funAjax2(){
			 $.ajax({
		            type : 'POST',
		            url : 'http://localhost:8080/oauth/token',
		            headers: {
		                'Authorization':'Basic bXlfY2xpZW50X2lkOm15X2NsaWVudF9zZWNyZXQ=', 
		                'Content-Type':'application/x-www-form-urlencoded' ,
		                'Access-Control-Allow-Origin':'*'
		            }, 
		            crossDomain: true,
		            data : { 
		                'username' : '' + $("#staffId").val(),
		                'password' : '' + $("#staffPwd").val(),
		                'grant_type' : 'password'
		            },
		            success : function(response) {
		            		alert(response.access_token);
		                 var expiredAt = new Date();
		                    expiredAt.setSeconds(expiredAt.getSeconds() + response.expires_in);
		                    response.expires_at = expiredAt.getTime();
		                    localStorage.setItem('ls.token', JSON.stringify(response));
		                    alert("Authorization Bearer " + JSON.parse(localStorage.getItem("ls.token")).access_token );
		                    var link = '/*[[@{/}]]*/';
		                    $(location).attr('href',link);
		            },
		               error:function(request,status,error){
		                   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		                  } 
		        });
			
		}
		
		var Base64 = {

				// private property
				_keyStr : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",

				// public method for encoding
				encode : function (input) {
					var output = "";
					var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
					var i = 0;

					while (i < input.length) {

					  chr1 = input.charCodeAt(i++);
					  chr2 = input.charCodeAt(i++);
					  chr3 = input.charCodeAt(i++);

					  enc1 = chr1 >> 2;
					  enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
					  enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
					  enc4 = chr3 & 63;

					  if (isNaN(chr2)) {
						  enc3 = enc4 = 64;
					  } else if (isNaN(chr3)) {
						  enc4 = 64;
					  }

					  output = output +
						  this._keyStr.charAt(enc1) + this._keyStr.charAt(enc2) +
						  this._keyStr.charAt(enc3) + this._keyStr.charAt(enc4);

					}

					return output;
				},

				// public method for decoding
				decode : function (input)
				{
				    var output = "";
				    var chr1, chr2, chr3;
				    var enc1, enc2, enc3, enc4;
				    var i = 0;

				    input = input.replace(/[^A-Za-z0-9+/=]/g, "");

				    while (i < input.length)
				    {
				        enc1 = this._keyStr.indexOf(input.charAt(i++));
				        enc2 = this._keyStr.indexOf(input.charAt(i++));
				        enc3 = this._keyStr.indexOf(input.charAt(i++));
				        enc4 = this._keyStr.indexOf(input.charAt(i++));

				        chr1 = (enc1 << 2) | (enc2 >> 4);
				        chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
				        chr3 = ((enc3 & 3) << 6) | enc4;

				        output = output + String.fromCharCode(chr1);

				        if (enc3 != 64) {
				            output = output + String.fromCharCode(chr2);
				        }
				        if (enc4 != 64) {
				            output = output + String.fromCharCode(chr3);
				        }
				    }

				    return output;
				}
			}

	</script>

  </body>
</html>