-- Table: public.client

-- DROP TABLE IF EXISTS public.client;

CREATE TABLE IF NOT EXISTS public.client
(
    id bigint NOT NULL,
    created_timestamp timestamp without time zone,
    date_of_birth date,
    email_address character varying(255) COLLATE pg_catalog."default",
    mobile_number character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    surname character varying(255) COLLATE pg_catalog."default",
    updated_timestamp timestamp without time zone,
    CONSTRAINT client_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

-- Table: public.products

-- DROP TABLE IF EXISTS public.products;

CREATE TABLE IF NOT EXISTS public.products
(
    id bigint NOT NULL,
    balance numeric(19,2),
    created_timestamp timestamp without time zone,
    name character varying(255) COLLATE pg_catalog."default",
    type character varying(255) COLLATE pg_catalog."default",
    updated_timestamp timestamp without time zone,
    CONSTRAINT products_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.products
    OWNER to postgres;



    -- Table: public.client_product_item

    -- DROP TABLE IF EXISTS public.client_product_item;

    CREATE TABLE IF NOT EXISTS public.client_product_item
    (
        id bigint NOT NULL,
        amount numeric(19,2),
        created_timestamp timestamp without time zone,
        updated_timestamp timestamp without time zone,
        client_id bigint,
        product_id bigint,
        CONSTRAINT client_product_item_pkey PRIMARY KEY (id),
        CONSTRAINT fksi7rtqvcfh88y8kbhpe5o3hfs FOREIGN KEY (product_id)
            REFERENCES public.products (id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION,
        CONSTRAINT fkt1diw4f0vpolacnv7wro24xpi FOREIGN KEY (client_id)
            REFERENCES public.client (id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

    ALTER TABLE IF EXISTS public.client_product_item
        OWNER to postgres;

-- Table: public.withdrawal_process

-- DROP TABLE IF EXISTS public.withdrawal_process;

CREATE TABLE IF NOT EXISTS public.withdrawal_process
(
    id bigint  NULL ,
    lastupdated timestamp without time zone,
    previous_balance numeric(19,2),
    status character varying(255) COLLATE pg_catalog."default",
    withdrawal_amount numeric(19,2),
    client_id bigint,
    product_id bigint,
    CONSTRAINT withdrawal_process_pkey PRIMARY KEY (id),
    CONSTRAINT fkl6b3kw0m53rew1ulqqitxh42s FOREIGN KEY (client_id)
        REFERENCES public.client (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkm6ibmjjr1p9ngce2r1uc3fts6 FOREIGN KEY (product_id)
        REFERENCES public.products (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.withdrawal_process
    OWNER to postgres;