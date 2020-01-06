--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

-- Started on 2020-01-06 16:38:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

DROP TABLE advance_type CASCADE; 

--
-- TOC entry 186 (class 1259 OID 28093)
-- Name: advance_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE advance_type (
    id bigint NOT NULL,
    version bigint NOT NULL,
    unit_name character varying(255),
    default_max_value numeric(19,4),
    updatable boolean,
    unit_precision numeric(19,4),
    active boolean,
    percentage boolean,
    quality_form boolean,
    read_only boolean DEFAULT false NOT NULL
);


ALTER TABLE advance_type OWNER TO postgres;

--
-- TOC entry 2496 (class 0 OID 28093)
-- Dependencies: 186
-- Data for Name: advance_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO advance_type (id, version, unit_name, default_max_value, updatable, unit_precision, active, percentage, quality_form, read_only) VALUES (505, 5, 'children', 100.0000, false, 0.0100, true, true, false, false);
INSERT INTO advance_type (id, version, unit_name, default_max_value, updatable, unit_precision, active, percentage, quality_form, read_only) VALUES (506, 4, 'percentage', 100.0000, false, 0.0100, true, true, false, false);
INSERT INTO advance_type (id, version, unit_name, default_max_value, updatable, unit_precision, active, percentage, quality_form, read_only) VALUES (507, 3, 'units', 2147483647.0000, false, 1.0000, true, false, false, false);
INSERT INTO advance_type (id, version, unit_name, default_max_value, updatable, unit_precision, active, percentage, quality_form, read_only) VALUES (508, 2, 'subcontractor', 100.0000, false, 0.0100, true, true, false, false);
INSERT INTO advance_type (id, version, unit_name, default_max_value, updatable, unit_precision, active, percentage, quality_form, read_only) VALUES (509, 1, 'timesheets', 100.0000, false, 0.0100, true, true, false, true);


--
-- TOC entry 2379 (class 2606 OID 28097)
-- Name: advance_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY advance_type
    ADD CONSTRAINT advance_type_pkey PRIMARY KEY (id);


--
-- TOC entry 2381 (class 2606 OID 28663)
-- Name: advance_type_unit_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY advance_type
    ADD CONSTRAINT advance_type_unit_name_key UNIQUE (unit_name);


--
-- TOC entry 2501 (class 0 OID 0)
-- Dependencies: 186
-- Name: advance_type; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE advance_type FROM PUBLIC;
REVOKE ALL ON TABLE advance_type FROM postgres;
GRANT ALL ON TABLE advance_type TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE advance_type TO libreplan;


-- Completed on 2020-01-06 16:38:03

--
-- PostgreSQL database dump complete
--

