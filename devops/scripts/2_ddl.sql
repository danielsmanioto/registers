alter table product add column login varchar(255);
alter table product  add constraint FKim4ixgnga8h4ou8mw999v8mue foreign key (login) references user_reg (login)

