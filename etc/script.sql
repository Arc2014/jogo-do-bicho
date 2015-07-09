--#script jogo-do-bicho

CREATE DATABASE jogo;

CREATE TABLE usuario (
  id BIGINT PRIMARY KEY,
  login VARCHAR(50),
  senha VARCHAR(100)
);

create table aposta (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  numero VARCHAR(4),
  valor_aposta_primeiro_premio DOUBLE,
  valor_aposta_segundo_premio DOUBLE,
  valor_aposta_terceiro_premio DOUBLE,
  valor_aposta_quarto_premio DOUBLE,
  valor_aposta_quinto_premio DOUBLE,
  valor_aposta_sexto_premio DOUBLE,
  valor_aposta_setimo_premio DOUBLE
);