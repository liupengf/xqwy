<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>jQuery页面过渡转换</title>
		<link rel="stylesheet" type="text/css" href="res/ui/metronic/css/default1.css" />
		<link rel="stylesheet" type="text/css" href="res/ui/metronic/css/multilevelmenu.css" />
		<link rel="stylesheet" type="text/css" href="res/ui/metronic/css/component.css" />
		<link rel="stylesheet" type="text/css" href="res/ui/metronic/css/animations.css" />
		<script src="res/ui/metronic/js/modernizr.custom.js"></script>
	</head>
	<body>	
 
		<div class="pt-triggers">
			<button id="iterateEffects" class="pt-touch-button">Slide</button>
			<!--a id="slideId" href="#">Slide</a-->
			<!--div id="dl-menu" class="dl-menuwrapper">
				<button>选择</button>
				<ul class="dl-menu">
					<li>
						<a href="#">Move</a>
						<ul class="dl-submenu">
							<li class="dl-back"><a href="#">back</a></li>
							<li data-animation="3"><a href="#">增加按钮</a></li>
						</ul>
					</li>
					<li data-animation="67"><a href="#">Slide</a></li>
				</ul>
			</div--><!-- /dl-menu-wrapper-->
		</div><!-- /triggers -->
		
		
		
		<div id="pt-main" class="pt-perspective">
			<div class="pt-page pt-page-1">
			        首页面1
			</div>
			<div class="pt-page pt-page-2"><h1>jQuery页面过渡转换2</h1></div>
			<div class="pt-page pt-page-3"><h1>jQuery页面过渡转换3</h1></div>
			<div class="pt-page pt-page-4"><h1>jQuery页面过渡转换4</h1></div>
			<div class="pt-page pt-page-5"><h1>jQuery页面过渡转换5</h1></div>
			<div class="pt-page pt-page-6"><h1>jQuery页面过渡转换6</h1></div> 
		</div>

		<div class="pt-message">
			<p>Your browser does not support CSS animations.</p>
		</div>
		
       <script type="text/javascript" src="res/ui/metronic/js/jquery-1.10.1.min.js"></script>
		<script src="res/ui/metronic/js/jquery.dlmenu.js"></script>
		<script src="res/ui/metronic/js/pagetransitions.js"></script>
	</body>
</html>
