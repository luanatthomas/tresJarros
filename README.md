# Algoritmos e Estruturas de Dados II
## Trabalho 1 - Os três Jarros do Sheik
### Autora - Luana Thomas
### Link para o [Relatório final](/T1 Alest II - Luana Thomas.pdf) do projeto.

Você está prestando assessoria para o sheik de um emirado distante, que deseja que você resolva um problema que atormenta sua família há gerações: segundo a lenda, um ancestral do sheik recebeu de um gênio três jarros com água e devia mover a água de um para o outro até atingir quantidades estabelecidas pelo gênio. Isto nem sempre era possível, e por isso o sheik é atormentado por dúvidas.
Agora o problema foi passado para você, e você deve fazer o que puder, sempre respeitando as regras originais do problema:
  
  1. É proibido jogar água fora.
  2. É proibido pegar água de uma fonte.
  3. Você só pode esvaziar um jarro em outro ou completar o outro jarro até a borda.

É claro que você não quer passar o dia brincando com jarros e prefere escrever um programa que solucione o problema. Para isso seu programa deve ler os dados de entrada abaixo:

  - As capacidades c1, c2 e c3 dos três jarros dados pelo gênio. (Estas capacidades serão de no máximo 40 litros cada).
  - As quantidades de água a1, a2 e a3 contidas nos três jarros dados pelo gênio.
  - As quantidades de água t1, t2 e t3 desejadas nos três jarros ao final dos movimentos.
  
Seu programa deve ler os dados e determinar o menor número possível de movimentos para deixar a água dividida da maneira desejada.
Por exemplo, poderíamos ter a seguinte entrada:
 ```
 6 10 15
 5  7  8
 0  5 15
 ```
Neste caso é fácil ver que com apenas dois movimentos é possível chegar na situaçào desejada.
Infelizmente, às vezes pode demorar mais, ou talvez nem seja possível chegar na resposta, e neste caso seu programa deve informar que ele é impossível.
Você deve usar os casos de teste que o sheik e as tribos locais vão colocar na página da disciplina e resolver o problema para cada um deles. Ao final você deve apresentar um relatório descrevendo:
  - Qual o problema sendo resolvido;
  - Como o problema foi modelado;
  - Como é o processo de solução, apresentando exemplos e algoritmos;
  - Os resultados dos casos de teste;
  - Conclusões.

