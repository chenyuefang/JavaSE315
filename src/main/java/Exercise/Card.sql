show databases;

drop database if exists db_Card;
create database `db_Card`;

drop table if exists db_Card.CardManagement;
create table db_Card.CardManagement
(
  id         int primary key comment '学号',
  name       varchar(255) not null comment '姓名',
  password   varchar(255) not null comment '密码',
  class_name varchar(255) not null comment '班级名称',
  money      double       not null comment '余额',
  balance    double       not null comment '饭卡对应的银行卡的钱数',
  productId  int comment '商品号'
) comment '饭卡管理系统表';

drop table if exists db_Card.product;
create table db_Card.product
(
  id      int primary key comment '商品号',
 name  varchar(255) not null comment '商品名',
 price double not null comment '价格'

) comment '商品表';

select *
from db_Card.product;

select *

from  db_Card.CardManagement;

alter table db_Card.CardManagement
  add constraint
    CardManagement_fk_productId
    foreign key (productId)
      references db_Card.product (id);

 insert into db_Card.CardManagement value (1,'Tom','123','C',100.0,50.0,01);
insert into db_Card.CardManagement value (2,'Jerry','456','Java',138.5,110.0,03);

 insert into db_Card.product value (01,'铅笔',1.00);
insert into db_Card.product value (02,'本子',2.00);
insert into db_Card.product value (03,'圆珠笔',2.50);