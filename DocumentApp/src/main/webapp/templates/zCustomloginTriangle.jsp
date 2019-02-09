<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

<style>
body {
	background-color: #e3e7ed;
	background-size: cover;
	font-family: 'Open Sans', sans-serif;
	font-weight: 300;
}

#iosBlurBg {
	resize: horizontal;
	position: relative;
	/*width: 100%;
	height: 100vh;*/
	border-top: 450px solid transparent;
	border-left: 550px solid rgba(0,0,0,0.04);
	border-bottom: 450px solid transparent;
	background: linear-gradient(rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0.1));
	/*box-shadow: 1px 1px 25px #999;*/
}

#whiteBg {
	resize: horizontal;
	position: absolute;
	top: -410px;
	right: 0;
	border-top: 410px solid transparent;
	border-left: 505px solid rgba(255,255,255,1);
	border-bottom: 410px solid transparent;
	border-right: 30px solid transparent;
	background: linear-gradient(rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 1));
}

#bottomEnter{
	position: absolute;
	top: 500px;
	left: 150px;
	z-index: -2;
	border-top: 200px solid transparent;
	border-right: 300px solid #15224a;
	border-bottom: 150px solid transparent;
	transform: rotate(-2deg);
}

#bottomBlurBg{
	position: absolute;
	top: 490px;
	left: 110px;
	z-index: -1;
	border-top: 200px solid transparent;
	border-right: 260px solid rgba(69,138,182,0.4);
	border-bottom: 120px solid transparent;
	transform: rotate(10deg);
}

.enterButton{
	position: absolute;
	top: 660px; 
	left: 330px;
	width: 70px;
	height: 70px;
	text-align: center;
}

.text-white{
	color: #fff;
}

.enterText{
	text-transform: uppercase;
	font-size: 20px;
	font-weight: 300;
	font-family: 'Open Sans', sans-serif;
}

.loginForm{
	position: absolute;
	top: 300px;
	left: 70px;
}

.title{
	 font-weight: 300;
	 font-size: 24px;
	 line-height: 1;
}

.title span{
	font-weight: 800;
	/*letter-spacing: 3px;*/
}

.title hr{
	width: 150px;
	border-width: 2px;
	border-color: #67e2fb; 
	margin: 0;

}

hr.short{
	width: 50px;
	border-width: 2px;
	border-color: #67e2fb; 
	float: left;
	margin: 0;

}


/*= input focus effects css
=========================== */
:focus{outline: none;}

.col-3{float: left; width: 100%; margin-top: 20px; margin-bottom: 0;} 
input{margin-top: 15px;font: 15px/24px "Open Sans", sans-serif; color: #333; width: 100%; box-sizing: border-box; letter-spacing: 1px; width: 65%;}

input::placeholder{
	text-transform: uppercase;
	letter-spacing: 0;
	font-size: 20px;
	font-weight: 300;
	padding-left: 15px;
}

.effect-2{border: 0; padding: 7px 0; border-bottom: 1px solid #ccc;}

.forget button{
	margin-top: 50px;
	border-radius: 0;
	color: #aaa;
	margin-left: 50px;
	font-weight: 700;
}
</style>
</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-sm-6 col-xs-6 col-md-offset-3">
  			<div id="iosBlurBg">
  				<div id="whiteBg"></div>
  			</div>
  			<div id="bottomEnter"></div>
  			<div id="bottomBlurBg"></div>
  			<!-- Login Form -->
  			<div class="loginForm">
  				<div class="title">
  					<p>LOG INTO<br><span>SYSTEM</span></p>
  					<hr>
  					<hr class="short">
  				</div>
  				<form>
  					<div class="col-3">
			        	<input class="effect-2" type="text" placeholder="Login...">
			            <span class="focus-border"></span>

			            <input class="effect-2" type="password" placeholder="Password...">
			            <span class="focus-border"></span>
			        </div>

			        <div class="forget">
			        	<button class="btn btn-default btn-sm">FORGOT PASSWORD?</button>
			        </div>

  				</form>
  			</div>
  			<a href="#">
  				<div class="enterButton">
	  				<i class="fa fa-lock fa-2x text-white"></i><br>
	  				<span class="enterText text-white">Enter</span>
	  			</div>
  			</a>
		</div>
	</div>
</div>
</body>
</html>