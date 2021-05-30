#language: pt
  Funcionalidade: Busca Curso

    Cenario: Busca por Um item
      Dado que acesso o site da Iterasys
      Quando consulto pelo curso "Mantis"
      Entao exibe uma lista com curso "Mantis"
      Quando clico em Matricule-se
      Entao exibe o titulo "Mantis" e o valor "R$ 49,99"