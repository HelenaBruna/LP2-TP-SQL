create schema aulaJava;
use aulaJava;

Create table tbCargos
(
	cd_cargos smallint,
	ds_cargos char(20),
	constraint pk_cargos primary key  (cd_cargos)
);

Create table tbFunc
(
	cod_func decimal(9),
	nome_func char(80),
	sal_func decimal,
	cod_cargos smallint,
	constraint pk_func primary key (cod_func),
	constraint fk_func foreign key (cod_cargos) references tbCargos (cd_cargos)
);

