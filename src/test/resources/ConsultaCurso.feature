#language:pt
  Funcionalidade: Consulta Curso
    Consultar por um curso no site da Iterasys

  Cenario: Consulta por um termo
    Dado que visito o site da Iterasys
    Quando preencho a consulta com "Mantis" e clico na Lupa
    Entao visualizo a oferta do curso "Mantis"
    Quando clico em Matricule-se no curso
    Entao visualizo curso "Mantis" no carrinho e seu valor como "R$ 49,99"