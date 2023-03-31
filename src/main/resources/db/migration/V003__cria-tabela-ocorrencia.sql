CREATE  TABLE IF NOT EXISTS ocorrencia(
  id bigint not null auto_increment,
  entrega_id bigint not null,
  descricao text not null,
  data_registro datetime not null,

  primary key(id)
);

ALTER table ocorrencia add constraint fk_ocorrencia_entrega
foreign key (entrega_id) references entrega (id);