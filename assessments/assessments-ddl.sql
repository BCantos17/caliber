--------------------------------------------------------
--  File created - Friday-January-20-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CALIBER_ASSESSMENT
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_ASSESSMENT" 
   (	"ASSESSMENT_ID" NUMBER(19,0), 
	"BATCH_ID" NUMBER(10,0), 
	"RAW_SCORE" NUMBER(10,0), 
	"ASSESSMENT_TITLE" VARCHAR2(255 CHAR), 
	"ASSESSMENT_TYPE" VARCHAR2(255 CHAR), 
	"WEEK_ID" NUMBER(19,0), 
	"WEEKLY_STATUS" NUMBER(5,0)
   )  
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_ASSESSMENT_CATEGORIES
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_ASSESSMENT_CATEGORIES" 
   (	"ASSESSMENTS_ASSESSMENT_ID" NUMBER(19,0), 
	"CATEGORIES_CATEGORY_ID" NUMBER(10,0)
   )
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_ASSESSMENT_CATEGORY
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_ASSESSMENT_CATEGORY" 
   (	"CATEGORY_ID" NUMBER(10,0), 
	"SKILL_CATEGORY" VARCHAR2(255 CHAR)
   ) 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_BATCH_NOTE
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_BATCH_NOTE" 
   (	"BATCH_ID" NUMBER(10,0), 
	"WEEK_ID" NUMBER(10,0), 
	"NOTE_ID" NUMBER(10,0)
   )  
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_GRADE
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_GRADE" 
   (	"GRADE_ID" NUMBER(19,0), 
	"DATE_RECEIVED" TIMESTAMP (6), 
	"SCORE" NUMBER(10,0), 
	"TRAINEE_ID" NUMBER(10,0), 
	"ASSESSMENT_ID" NUMBER(19,0)
   ) 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_NOTE
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_NOTE" 
   (	"NOTE_ID" NUMBER(10,0), 
	"NOTE_CONTENT" VARCHAR2(255 CHAR), 
	"NOTE_SUGAR" VARCHAR2(255 CHAR)
   )
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_QC_NOTE
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_QC_NOTE" 
   (	"TRAINEE_ID" NUMBER(10,0), 
	"WEEK_ID" NUMBER(10,0), 
	"NOTE_ID" NUMBER(10,0)
   ) 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_QC_STATUS
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_QC_STATUS" 
   (	"STATUS_ID" NUMBER(5,0), 
	"QC_STATUS" VARCHAR2(255 CHAR)
   ) 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_TRAINER_NOTE
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_TRAINER_NOTE" 
   (	"TRAINER_ID" NUMBER(10,0), 
	"WEEK_ID" NUMBER(10,0), 
	"NOTE_ID" NUMBER(10,0)
   ) 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CATEGORY_WEEKS
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CATEGORY_WEEKS" 
   (	"CATEGORY_CATEGORY_ID" NUMBER(10,0), 
	"WEEKS" NUMBER(10,0)
   )
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
--------------------------------------------------------
--  DDL for Table CALIBER_CATEGORY_WEEKS
--------------------------------------------------------

CREATE TABLE CALIBER_CATEGORY_WEEKS (
  Category_CATEGORY_ID NUMBER NOT NULL,
  WEEK_ID NUMBER NOT NULL
);

--------------------------------------------------------
--  DDL for Index SYS_C005845
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005845" ON "CALIBER"."CALIBER_ASSESSMENT" ("ASSESSMENT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005848
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005848" ON "CALIBER"."CALIBER_ASSESSMENT_CATEGORIES" ("ASSESSMENTS_ASSESSMENT_ID", "CATEGORIES_CATEGORY_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005850
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005850" ON "CALIBER"."CALIBER_ASSESSMENT_CATEGORY" ("CATEGORY_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005853
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005853" ON "CALIBER"."CALIBER_BATCH_NOTE" ("NOTE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005859
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005859" ON "CALIBER"."CALIBER_GRADE" ("GRADE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005861
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005861" ON "CALIBER"."CALIBER_NOTE" ("NOTE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005863
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005863" ON "CALIBER"."CALIBER_QC_NOTE" ("NOTE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005865
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005865" ON "CALIBER"."CALIBER_QC_STATUS" ("STATUS_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005868
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005868" ON "CALIBER"."CALIBER_TRAINER_NOTE" ("NOTE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table CALIBER_ASSESSMENT
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT" ADD PRIMARY KEY ("ASSESSMENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT" MODIFY ("WEEK_ID" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT" MODIFY ("ASSESSMENT_TYPE" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT" MODIFY ("ASSESSMENT_TITLE" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT" MODIFY ("BATCH_ID" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT" MODIFY ("ASSESSMENT_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_ASSESSMENT_CATEGORIES
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT_CATEGORIES" ADD PRIMARY KEY ("ASSESSMENTS_ASSESSMENT_ID", "CATEGORIES_CATEGORY_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT_CATEGORIES" MODIFY ("CATEGORIES_CATEGORY_ID" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT_CATEGORIES" MODIFY ("ASSESSMENTS_ASSESSMENT_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_ASSESSMENT_CATEGORY
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT_CATEGORY" ADD PRIMARY KEY ("CATEGORY_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT_CATEGORY" MODIFY ("CATEGORY_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_BATCH_NOTE
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_BATCH_NOTE" ADD PRIMARY KEY ("NOTE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_BATCH_NOTE" MODIFY ("NOTE_ID" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_BATCH_NOTE" MODIFY ("WEEK_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_GRADE
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_GRADE" ADD PRIMARY KEY ("GRADE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_GRADE" MODIFY ("ASSESSMENT_ID" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_GRADE" MODIFY ("TRAINEE_ID" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_GRADE" MODIFY ("SCORE" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_GRADE" MODIFY ("DATE_RECEIVED" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_GRADE" MODIFY ("GRADE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_NOTE
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_NOTE" ADD PRIMARY KEY ("NOTE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_NOTE" MODIFY ("NOTE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_QC_NOTE
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_QC_NOTE" ADD PRIMARY KEY ("NOTE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_QC_NOTE" MODIFY ("NOTE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_QC_STATUS
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_QC_STATUS" ADD PRIMARY KEY ("STATUS_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_QC_STATUS" MODIFY ("STATUS_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_TRAINER_NOTE
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_TRAINER_NOTE" ADD PRIMARY KEY ("NOTE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_TRAINER_NOTE" MODIFY ("NOTE_ID" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_TRAINER_NOTE" MODIFY ("WEEK_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CATEGORY_WEEKS
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CATEGORY_WEEKS" MODIFY ("CATEGORY_CATEGORY_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CALIBER_ASSESSMENT
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT" ADD CONSTRAINT "FK_IW3DXFHRKJU12FPT3KC4MUM3" FOREIGN KEY ("WEEKLY_STATUS")
	  REFERENCES "CALIBER"."CALIBER_QC_STATUS" ("STATUS_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CALIBER_ASSESSMENT_CATEGORIES
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT_CATEGORIES" ADD CONSTRAINT "FK_LPO9H4VW1XUHBXWTWU9HCTSKQ" FOREIGN KEY ("ASSESSMENTS_ASSESSMENT_ID")
	  REFERENCES "CALIBER"."CALIBER_ASSESSMENT" ("ASSESSMENT_ID") ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_ASSESSMENT_CATEGORIES" ADD CONSTRAINT "FK_PC881BX9QICMCUEMF3XFEXI8Y" FOREIGN KEY ("CATEGORIES_CATEGORY_ID")
	  REFERENCES "CALIBER"."CALIBER_ASSESSMENT_CATEGORY" ("CATEGORY_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CALIBER_BATCH_NOTE
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_BATCH_NOTE" ADD CONSTRAINT "FK_GRJ3FKJLSPD63K544828KL1QX" FOREIGN KEY ("NOTE_ID")
	  REFERENCES "CALIBER"."CALIBER_NOTE" ("NOTE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CALIBER_GRADE
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_GRADE" ADD CONSTRAINT "FK_JCQEJLMKF8JA574MPH22YL483" FOREIGN KEY ("ASSESSMENT_ID")
	  REFERENCES "CALIBER"."CALIBER_ASSESSMENT" ("ASSESSMENT_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CALIBER_QC_NOTE
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_QC_NOTE" ADD CONSTRAINT "FK_L9LTNXOGAOH6R9LYNC6BAQCL0" FOREIGN KEY ("NOTE_ID")
	  REFERENCES "CALIBER"."CALIBER_NOTE" ("NOTE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CALIBER_TRAINER_NOTE
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_TRAINER_NOTE" ADD CONSTRAINT "FK_724ARGULJEB4WQSU0ONTLW1HD" FOREIGN KEY ("NOTE_ID")
	  REFERENCES "CALIBER"."CALIBER_NOTE" ("NOTE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CATEGORY_WEEKS
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CATEGORY_WEEKS" ADD CONSTRAINT "FK_71WXRGMIHAJE94F4S024RH58T" FOREIGN KEY ("CATEGORY_CATEGORY_ID")
	  REFERENCES "CALIBER"."CALIBER_ASSESSMENT_CATEGORY" ("CATEGORY_ID") ENABLE;

--------------------------------------------------------
--  Ref Constraints for Table CALIBER_CATEGORY_WEEKS
--------------------------------------------------------
ALTER TABLE CALIBER_CATEGORY_WEEKS 
ADD CONSTRAINT FK_SRRGW463Y FOREIGN KEY (Category_CATEGORY_ID) 
REFERENCES CALIBER_ASSESSMENT_CATEGORY (CATEGORY_ID);
     
--------------------------------------------------------
--  DDL for Sequence CATEGORY_ID_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "CALIBER"."CATEGORY_ID_SEQUENCE" START WITH 1 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence ASSESSMENT_ID_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "CALIBER"."ASSESSMENT_ID_SEQUENCE" START WITH 1 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence GRADE_ID_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "CALIBER"."GRADE_ID_SEQUENCE" START WITH 1 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence NOTE_ID_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "CALIBER"."NOTE_ID_SEQUENCE"  START WITH 1 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence QC_STATUS_ID_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "CALIBER"."QC_STATUS_ID_SEQUENCE" START WITH 1 INCREMENT BY 1;
   

