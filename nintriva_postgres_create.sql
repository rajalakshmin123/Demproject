CREATE TABLE "public.customer" (
	"id" serial NOT NULL,
	"name" TEXT NOT NULL,
	"email" TEXT NOT NULL,
	"customerid" TEXT NOT NULL,
	"status" TEXT NOT NULL,
	"password" TEXT NOT NULL,
	"phone" TEXT NOT NULL,
	CONSTRAINT "customer_pk" PRIMARY KEY ("customerid")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.retailer" (
	"id" serial NOT NULL,
	"name" TEXT NOT NULL,
	"email" TEXT NOT NULL,
	"retailerid" TEXT NOT NULL,
	"status" TEXT NOT NULL DEFAULT 'inactive',
	"password" TEXT NOT NULL,
	"phone" TEXT NOT NULL,
	CONSTRAINT "retailer_pk" PRIMARY KEY ("retailerid")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.product" (
	"id" serial NOT NULL,
	"product_name" TEXT NOT NULL,
	"price" int NOT NULL,
	"picture" TEXT NOT NULL,
	"description" TEXT NOT NULL,
	"retailerid" TEXT NOT NULL
) WITH (
  OIDS=FALSE
);





ALTER TABLE "product" ADD CONSTRAINT "product_fk0" FOREIGN KEY ("retailerid") REFERENCES "retailer"("retailerid");




