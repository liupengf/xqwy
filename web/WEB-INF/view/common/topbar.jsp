
<%@page import="org.thcic.ejw.util.AuthenticationUtil"%>
<link rel="stylesheet" href="">
<div class="header navbar navbar-inverse navbar-static-top">
	<!-- BEGIN TOP NAVIGATION BAR -->
	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="brand" href="#"> 
				<img src="${baseUrl}/res/ui/metronic/image/logo.png" alt="Logo" /> 
				<span style="padding-left:98px;padding-top:1px;display:inline-block"></span>
			</a>
			<!-- 显示在主题右侧的4个图标 -->
			<ul class="nav pull-right">
				<!--li class="dropdown" id="header_notification_bar">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-warning-sign"></i>
							<span class="badge">6</span>
						</a>
						<ul class="dropdown-menu extended notification">
					   	   <li>
							 <p>你有14封新的通知</p>
						   </li>
						   <li>
							<a href="#">
								<span class="label label-success">
							   		<i class="icon-plus"></i>
								</span>
							         新注册用户. 
							 	<span class="time">当前</span>
							</a>
						  </li>
							<li>
								<a href="#">
								<span class="label label-important">
									<i class="icon-bolt"></i>
								</span>
								服务器端 #12 上传. 
							<span class="time">15分钟</span>
								</a>
							</li>
							<li>
								<a href="#">
							<span class="label label-warning"><i class="icon-bell"></i></span>
								服务器端 #2没有响应.
								<span class="time">22分钟</span>
								</a>
							</li>
							<li>
								<a href="#">
								<span class="label label-info">
								   <i class="icon-bullhorn"></i>
								</span>
								应用错误
								<span class="time">40 分钟</span>
								</a>
							</li>
							<li>
								<a href="#">
								<span class="label label-important"><i class="icon-bolt"></i></span>
								数据库 上传 68%. 
								<span class="time">2小时</span>
								</a>
							</li>
							<li>
								<a href="#">
									<span class="label label-important">
								  		<i class="icon-bolt"></i>
									</span>
									2 个用户 IP被拦截.
									<span class="time">5小时</span>
								</a>
							</li>
							<li class="external">
								<a href="#">查看所有的通知
								  <i class="m-icon-swapright"></i>
								</a>
							</li>
						</ul>
					</li>
				<li class="dropdown" id="header_inbox_bar"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-envelope"></i> <span class="badge">5</span>
				</a>
					<ul class="dropdown-menu extended inbox">
						<li>
							<p>你有12条新的信息</p>
						</li>
						<li><a href="inbox.jsp?a=view"> <span class="photo"><img
									src="${baseUrl}/res/ui/metronic/image/avatar2.jpg" alt="" /></span> 
								<span class="subject"> <span class="from">王晓丽</span> <span
									class="time">现在</span>
							</span> <span class="message">
									你好！今天是2014年新的一年，祝你新年快乐！
							</span>
						</a></li>
						<li><a href="inbox.jsp?a=view"> <span class="photo"><img
									src="${baseUrl}/res/ui/metronic/image/avatar3.jpg" alt="" /></span> <span
								class="subject"> <span class="from">吕伟</span> <span
									class="time">16分钟</span>
							</span> <span class="message"> 雷哥，最近还好啊，呵呵。。。。有时间的话，可以帮我买台电脑吗。 </span>
						</a></li>
						<li class="external"><a href="inbox.jsp">查看所有的信息 <i
								class="m-icon-swapright"></i>
						</a></li>
					</ul></li>
					<li class="dropdown" id="header_task_bar"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-tasks"></i> <span class="badge">3</span>
					</a>
					<ul class="dropdown-menu extended tasks">
						<li>
							<p>你有3个要完成的任务</p>
						</li>
						<li><a href="#"> <span class="task"> <span
									class="desc">数据库迁移</span> <span class="percent">10%</span>
							</span> <span class="progress progress-warning progress-striped">
									<span style="width: 10%;" class="bar"></span>
							</span>
						</a></li>
						<li><a href="#"> <span class="task"> <span
									class="desc">web服务器升级</span> <span class="percent">58%</span>
							</span> <span class="progress progress-info"> <span
									style="width: 58%;" class="bar"></span>
							</span>
						</a></li>
						<li><a href="#"> <span class="task"> <span
									class="desc">移动设备的开发</span> <span class="percent">85%</span>
							</span> <span class="progress progress-success"> <span
									style="width: 85%;" class="bar"></span>
							</span>
						</a></li>
						<li class="external"><a href="#">查看所有的任务<i
								class="m-icon-swapright"></i></a></li>
					</ul>
				</li> -->
				<!-- 下拉用户 -->
				<li class="dropdown user"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <img
						src="${baseUrl}/res/ui/metronic/image/man.jpg" alt=""></img>
						<span class="username">【${username}】</span> 
				</a>
					</li>
			</ul>
		</div>
	</div>
</div>