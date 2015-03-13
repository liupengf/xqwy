#---乱码解决方式进入mysql命令set names utf8;重建数据库
#--创建房型资料表---------
create table xqwy_fxzl(
fxzlid int not null primary key,
lpbh varchar(10) ,#--楼盘编号---
szlc varchar(10),#----所在楼层
jzmj varchar(10),#----建筑面积
symj varchar(10),#----使用面积
hx varchar(10),#------户型
fwbh varchar(10),#------房屋编号
xqmc varchar(20)# ---小区名称
);

#--住户信息表
create table xqwy_zhxx(
sfz varchar(20) not null primary key,#--住户身份证
xm varchar(20),#--姓名
xqmc varchar(20),#--小区名称
address varchar(200)#--详细地址
);
#--创建物业收费项目表
create table xqwy_sfxm (
sfid varchar(10) not null primary key ,#收费编号
sfmc varchar(100)#收费名称
);
#--停车场信息表
create table xqwy_tccxx(
xxid int not null primary key ,#主键id
xqmc varchar(20),#小区名称
tccmc varchar(20),#停车场名称
cwh varchar(10)#车位号
);
#--创建投诉表
create table xqwy_ts(
tsid int not null primary key,#投诉id主键
tsr varchar(20),#--投诉人
tssj varchar(20),#投诉日期
jzxq varchar(20),#居住地址
tslb varchar(20),#投诉类别
tsnr varchar(200)#投诉内容
);
#---创建报修表
create table xqwy_bx(
bxid int not null primary key,#报修id主键
bxr varchar(20),#报修人
bxsj varchar(20),#报修日期
jzxq varchar(20),#居住地址
bxlb varchar(20),#报修类别
bxnr varchar(200)#报修内容
);
#--创建住户停车位表
create table xqwy_zhtcw(
sfz varchar(20) not null primary key,#身份证
xm varchar(20),#姓名
xqmc varchar(20),#小区名称
tccmc varchar(20),#停车场名称
cwh varchar(10)#车位号
);
#创建用户表
CREATE TABLE xqwy_users (
 username varchar(20) not null primary key,
     pwd varchar(50)
    );
#---创建缴费管理表
create table xqwy_jfgl(
jfid int not null primary key,
sfz varchar(20),#身份证
xm varchar(20),#姓名
xqmc varchar(20),#小区名称
address varchar(100),#具体地址
sfmc varchar(20),#收费名称
je varchar(20),#金额
yjje varchar(20),#已交金额
sfrq varchar(20)#收费日期
);
insert into xqwy_users (username ,pwd) values ('admin','21232f297a57a5a743894a0e4a801fc3');