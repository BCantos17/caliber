--------------------------------------------------------
--  File created - Thursday-January-19-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CALIBER_BATCH
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_BATCH" 
   (	"BATCH_ID" NUMBER(10,0), 
	"BORDERLINE_GRADE_THRESHOLD" NUMBER(5,0), 
	"END_DATE" TIMESTAMP (6), 
	"GOOD_GRADE_THRESHOLD" NUMBER(5,0), 
	"LOCATION" VARCHAR2(255 CHAR), 
	"SKILL_TYPE" VARCHAR2(255 CHAR), 
	"START_DATE" TIMESTAMP (6), 
	"TRAINING_NAME" VARCHAR2(255 CHAR), 
	"TRAINING_TYPE" VARCHAR2(255 CHAR), 
	"CO_TRAINER_ID" NUMBER(10,0), 
	"TRAINER_ID" NUMBER(10,0)
   )  
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_CATEGORY
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_CATEGORY" 
   (	"CATEGORY_ID" NUMBER(10,0), 
	"SKILL_CATEGORY" VARCHAR2(255 CHAR)
   )  
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_TIER
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_TIER" 
   (	"TIER_ID" NUMBER(5,0), 
	"RANKING" NUMBER(5,0), 
	"TIER" VARCHAR2(255 CHAR)
   )
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_TRAINEE
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_TRAINEE" 
   (	"TRAINEE_ID" NUMBER(10,0), 
	"TRAINEE_EMAIL" VARCHAR2(255 CHAR), 
	"TRAINEE_NAME" VARCHAR2(255 CHAR), 
	"TRAINING_STATUS" VARCHAR2(255 CHAR), 
	"BATCH_ID" NUMBER(10,0)
   ) 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_TRAINER
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_TRAINER" 
   (	"TRAINER_ID" NUMBER(10,0), 
	"EMAIL" VARCHAR2(255 CHAR), 
	"NAME" VARCHAR2(255 CHAR), 
	"SF_ACCOUNT" VARCHAR2(255 CHAR), 
	"SF_AUTHENTICATION_TOKEN" VARCHAR2(255 CHAR), 
	"SF_REFRESH_TOKEN" VARCHAR2(255 CHAR), 
	"TITLE" VARCHAR2(255 CHAR), 
	"TIER" NUMBER(5,0)
   ) 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CALIBER_WEEK
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CALIBER_WEEK" 
   (	"WEEK_ID" NUMBER(19,0), 
	"WEEK_NUMBER" NUMBER(10,0), 
	"BATCH_ID" NUMBER(10,0)
   )
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CATEGORY_COVERED
--------------------------------------------------------

  CREATE TABLE "CALIBER"."CATEGORY_COVERED" 
   (	"TOPICS_CATEGORY_ID" NUMBER(10,0), 
	"WEEKS_WEEK_ID" NUMBER(19,0)
   ) 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005642
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005642" ON "CALIBER"."CALIBER_BATCH" ("BATCH_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005644
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005644" ON "CALIBER"."CALIBER_CATEGORY" ("CATEGORY_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005648
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005648" ON "CALIBER"."CALIBER_TIER" ("TIER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005651
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005651" ON "CALIBER"."CALIBER_TRAINEE" ("TRAINEE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005660
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005660" ON "CALIBER"."CALIBER_TRAINER" ("TRAINER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005662
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005662" ON "CALIBER"."CALIBER_WEEK" ("WEEK_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005665
--------------------------------------------------------

  CREATE UNIQUE INDEX "CALIBER"."SYS_C005665" ON "CALIBER"."CATEGORY_COVERED" ("TOPICS_CATEGORY_ID", "WEEKS_WEEK_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table CALIBER_BATCH
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_BATCH" ADD PRIMARY KEY ("BATCH_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_BATCH" MODIFY ("TRAINER_ID" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_BATCH" MODIFY ("START_DATE" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_BATCH" MODIFY ("LOCATION" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_BATCH" MODIFY ("END_DATE" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_BATCH" MODIFY ("BATCH_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_CATEGORY
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_CATEGORY" ADD PRIMARY KEY ("CATEGORY_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_CATEGORY" MODIFY ("CATEGORY_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_TIER
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_TIER" ADD PRIMARY KEY ("TIER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_TIER" MODIFY ("TIER" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_TIER" MODIFY ("RANKING" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_TIER" MODIFY ("TIER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_TRAINEE
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_TRAINEE" ADD PRIMARY KEY ("TRAINEE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_TRAINEE" MODIFY ("BATCH_ID" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_TRAINEE" MODIFY ("TRAINEE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_TRAINER
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_TRAINER" ADD PRIMARY KEY ("TRAINER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_TRAINER" MODIFY ("TIER" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_TRAINER" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_TRAINER" MODIFY ("SF_REFRESH_TOKEN" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_TRAINER" MODIFY ("SF_AUTHENTICATION_TOKEN" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_TRAINER" MODIFY ("SF_ACCOUNT" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_TRAINER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_TRAINER" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CALIBER_TRAINER" MODIFY ("TRAINER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CALIBER_WEEK
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_WEEK" ADD PRIMARY KEY ("WEEK_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_WEEK" MODIFY ("WEEK_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CATEGORY_COVERED
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CATEGORY_COVERED" ADD PRIMARY KEY ("TOPICS_CATEGORY_ID", "WEEKS_WEEK_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CALIBER"."CATEGORY_COVERED" MODIFY ("WEEKS_WEEK_ID" NOT NULL ENABLE);
  ALTER TABLE "CALIBER"."CATEGORY_COVERED" MODIFY ("TOPICS_CATEGORY_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CALIBER_BATCH
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_BATCH" ADD CONSTRAINT "FK_35QJTOMOM338V680F3XKO7PLH" FOREIGN KEY ("TRAINER_ID")
	  REFERENCES "CALIBER"."CALIBER_TRAINER" ("TRAINER_ID") ENABLE;
  ALTER TABLE "CALIBER"."CALIBER_BATCH" ADD CONSTRAINT "FK_4IDDE4FODT9VMU6CIXCQ4S2P1" FOREIGN KEY ("CO_TRAINER_ID")
	  REFERENCES "CALIBER"."CALIBER_TRAINER" ("TRAINER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CALIBER_TRAINEE
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_TRAINEE" ADD CONSTRAINT "FK_I6XQ8I1717FWXU7UQBXHMGOWC" FOREIGN KEY ("BATCH_ID")
	  REFERENCES "CALIBER"."CALIBER_BATCH" ("BATCH_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CALIBER_TRAINER
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_TRAINER" ADD CONSTRAINT "FK_9WQCIP8LW28SG5QVBN1R05NVV" FOREIGN KEY ("TIER")
	  REFERENCES "CALIBER"."CALIBER_TIER" ("TIER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CALIBER_WEEK
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CALIBER_WEEK" ADD CONSTRAINT "FK_PQ4N2656CC0L0JWV3G420RTQI" FOREIGN KEY ("BATCH_ID")
	  REFERENCES "CALIBER"."CALIBER_BATCH" ("BATCH_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CATEGORY_COVERED
--------------------------------------------------------

  ALTER TABLE "CALIBER"."CATEGORY_COVERED" ADD CONSTRAINT "FK_E6X3G2E77COMVSN9G84Q1XWKC" FOREIGN KEY ("TOPICS_CATEGORY_ID")
	  REFERENCES "CALIBER"."CALIBER_CATEGORY" ("CATEGORY_ID") ENABLE;
  ALTER TABLE "CALIBER"."CATEGORY_COVERED" ADD CONSTRAINT "FK_G1Y6FXBO9IINPIV8I2VCSF90S" FOREIGN KEY ("WEEKS_WEEK_ID")
	  REFERENCES "CALIBER"."CALIBER_WEEK" ("WEEK_ID") ENABLE;
	
	--------------------------------------------------------
--  DDL for Sequence BATCH_ID_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "CALIBER"."BATCH_ID_SEQUENCE" START WITH 1 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence CATEGORY_ID_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "CALIBER"."CATEGORY_ID_SEQUENCE"  START WITH 1 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence HIBERNATE_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "CALIBER"."HIBERNATE_SEQUENCE"  START WITH 1 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence TIER_ID_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "CALIBER"."TIER_ID_SEQUENCE" START WITH 1 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence TRAINEE_ID_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "CALIBER"."TRAINEE_ID_SEQUENCE" START WITH 1 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence TRAINER_ID_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "CALIBER"."TRAINER_ID_SEQUENCE" START WITH 1 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence WEEK_ID_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "CALIBER"."WEEK_ID_SEQUENCE" START WITH 1 INCREMENT BY 1;

