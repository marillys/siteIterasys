#language: pt
  Funcionalidade: Busca por Produto
    Esquema do Cenario: Busca usando um termo
      Dado que acesso o site do Submarino
      Quando busco por <produto>
      Entao exibe a lista do <produto>
      E ao clicar no primeiro produto da lista
      Entao exibe a pagina com o <modelo> e o <preco>

      Exemplos:
      | produto      | modelo       | preco        |
      | "geladeira"  | "geladeira"  | "R$ 2.149,99"|
      | "Torradeira" | "Torradeira" | "R$ 99,90"   |