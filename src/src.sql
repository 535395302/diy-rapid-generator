drop index ix_scrapserial_sn;

drop table TWms_D_AdjustSerial;

/*==============================================================*/
/* Table: TWms_D_AdjustSerial                                   */
/*==============================================================*/
create table TWms_D_AdjustSerial (
   Id                   VARCHAR(40)          not null,
   ApplyId              VARCHAR(15)          not null,
   SerialNo             VARCHAR(20)          not null,
   OldStatus            VARCHAR(10)          not null,
   CostPrice            FLOAT8               not null,
   constraint PK_TWMS_D_ADJUSTSERIAL primary key (Id),
   constraint AK_SCRAPSERIAL2_TWMS_D_A unique (ApplyId, SerialNo)
);

comment on table TWms_D_AdjustSerial is
'参与库内调整的实物序列号';

comment on column TWms_D_AdjustSerial.Id is
'Id';

comment on column TWms_D_AdjustSerial.ApplyId is
'申请编号';

comment on column TWms_D_AdjustSerial.SerialNo is
'商品序列号';

comment on column TWms_D_AdjustSerial.OldStatus is
'调整前状态';

comment on column TWms_D_AdjustSerial.CostPrice is
'采购成本';

/*==============================================================*/
/* Index: ix_scrapserial_sn                                     */
/*==============================================================*/
create  index ix_scrapserial_sn on TWms_D_AdjustSerial (
SerialNo
);

alter table TWms_D_AdjustSerial
   add constraint FK_adjustserial1 foreign key (ApplyId)
      references TWms_D_AdjustMaster (ApplyId)
      on delete cascade on update cascade;
