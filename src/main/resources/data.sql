delete from Parts;
delete from Setup;
delete from "Order";
delete from Order_Setup;
delete from Setup_Parts;

insert into Parts (id, name, type)
values ( 'MOB_GRIP','MOB Grip tape','GRIP_TAPE');
insert into Parts (id, name, type)
values ( 'GRZ_GRIP','Grizzly Grip tape','GRIP_TAPE');
insert into Parts (id, name, type)
values ( 'JSU_GRIP','Jessup Grip tape','GRIP_TAPE');

insert into Parts (id, name, type)
values ( 'SUP_DECK','Supreme Deck','DECK');
insert into Parts (id, name, type)
values ( 'BAK_DECK','Baker Deck','DECK');
insert into Parts (id, name, type)
values ( 'STC_DECK','Santacruz Deck','DECK');

insert into Parts (id, name, type)
values ( 'ACE_TRUCK_STA_44','Ace Truck, Standard 44Size','TRUCK');
insert into Parts (id, name, type)
values ( 'IND_TRUCK_HOL_139','Independent Truck, Hollow  139Size','TRUCK');

insert into Parts (id, name, type)
values ( 'BNS_WHEEL_99A','Bones Wheel, 54mm 99A','WHEEL');
insert into Parts (id, name, type)
values ( 'SPF_WHEEL_101A','Spitfire Wheel, 56mm 101A','WHEEL');

insert into Parts (id, name, type)
values ( 'BNS_BEARING_REDS','Bones Reds','BEARING');
insert into Parts (id, name, type)
values ( 'BRS_BEARING_G3','Bronson G3','BEARING');

insert into Parts (id, name, type)
values ( 'BRO_HARDWARE_7_8','Bronze 56k 7/8\"','HARDWARE');
insert into Parts (id, name, type)
values ( 'IND_HARDWARE_1','Independent 1\"','HARDWARE');