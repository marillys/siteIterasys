#language: pt
  Funcionalidade: Busca Curso

    Cenario: Busca por Mantis
      Dado que acesso o site da Iterasys
      Quando consulto pelo curso "Mantis"
      Entao exibe uma lista com curso "Mantis"
      Quando clico em Matricule-se
      Entao exibe o titulo "Mantis" e o valor "R$ 49,99"

    Cenario: Busca por TestLink
      Dado que acesso o site da Iterasys
      Quando consulto pelo curso "TestLink"
      Entao exibe mensagem de curso nao encontrado

    Esquema do Cenario: Buscar varios cenarios
      Dado que acesso o site da Iterasys
      Quando consulto pelo <curso>
      Entao exibe uma lista com <curso>
      Quando clico em Matricule-se
      Entao exibe o titulo do <curso> e o <valor>

    Exemplos:
      | curso  | valor    |
      | "Mantis" | "R$ 49,99" |
      | "Preparatório CTFL" | "R$ 169,00" |