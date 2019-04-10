import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BotMazeTest {
   
    char [] _noEscape1 =
            { '#', 'X', '#', '#', '#', '#', '#', '#', '#', '#',
              '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#',
              '#', ' ', ' ', '#', '#', ' ', '#', ' ', ' ', '#',
              '#', ' ', ' ', '#', '#', ' ', ' ', '#', ' ', '#',
              '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#',
              '#', '#', ' ', '#', '#', ' ', ' ', '#', ' ', '#',
              '#', ' ', ' ', ' ', '#', ' ', '#', '#', ' ', '#',
              '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#',
              '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', '#',
              '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' };
           
    char [] _noEscape2 =
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
              '#', '#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#',
              '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#',
              '#', '#', '#', '#', '#', '#', ' ', ' ', '#', ' ', '#',
              '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#',
              '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', ' ', '#',
              '#', ' ', ' ', ' ', '#', '#', ' ', '#', '#', ' ', '#',
              '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', '#',
              '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', ' ', '#',
              '#', ' ', '#', ' ', '#', ' ', ' ', '#', '#', '#', '#',
              '#', '#', '#', '#', '#', '#', '#', '#', '#', 'X', '#' };

    char [] _mazeBook =
            { '#', 'X', '#', '#', '#', '#', '#', '#', '#', '#',
              '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#',
              '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#',
              '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#',
              '#', ' ', '#', '#', ' ', '#', ' ', ' ', ' ', '#',
              '#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#',
              '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#',
              '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#',
              '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#',
              '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' };
   
    char [] _mazeIsland =
        { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', 'X', '#', '#', '#', '#', '#',
          '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#',
          '#', ' ', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#', '#', ' ', '#',
          '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', '#',
          '#', ' ', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#',
          '#', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#',
          '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#',
          '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#',
          '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#',
          '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#',
          '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' };
   
    char [] _mazeMonster =
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
              '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#',
              '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#',
              '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#',
              '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#',
              '#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#', '#', ' ', '#',
              '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#',
              '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#', '#',
              '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#',
              '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#',
              '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', 'X',
              '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' };
   
    BotMaze.Maze noEscape1;
    BotMaze.Maze noEscape2;
   
    BotMaze.Maze mazeBook;
    BotMaze.Maze mazeIsland;
    BotMaze.Maze mazeMonster;
   
    String noEscape1Sol;
    String noEscape2Sol;
    String mazeBookSol;
    String mazeIslandSol;
    String mazeMonsterSol;
   
    @Before
    public void setUp() {
        noEscape1 = new BotMaze.Maze(10, 10, _noEscape1);
        noEscape2 = new BotMaze.Maze(11, 11, _noEscape2);
        mazeBook = new BotMaze.Maze(10, 10, _mazeBook);
        mazeIsland = new BotMaze.Maze(11, 17, _mazeIsland);
        mazeMonster = new BotMaze.Maze(12, 13, _mazeMonster);
       
        BotMaze.PartialSolution.solve(new BotMaze.PartialSolution(8, 1, noEscape1));
        BotMaze.PartialSolution.solve(new BotMaze.PartialSolution(1, 9, noEscape2));
        BotMaze.PartialSolution.solve(new BotMaze.PartialSolution(8, 8, mazeBook));
        BotMaze.PartialSolution.solve(new BotMaze.PartialSolution(1, 7, mazeIsland));
        BotMaze.PartialSolution.solve(new BotMaze.PartialSolution(1, 3, mazeMonster));
       
        noEscape1Sol = "# X # # # # # # # # #     #         # # #     # #   #     # #     # #     #   # # # # # # # # #   # # #   # #     #   # #       #   # #   # #   #             # # # #   # # #     # # # # # # # # # # #";
        noEscape2Sol = "# # # # # # # # # # # # #   # # # #   #   # # #             #   # # # # # # #     #   # # # #               # #   #   # #   #     # #       # #   # #   # #   #   # #   #   # # #   #   # #   #     # #   #   #     # # # # # # # # # # # # # X #";
        mazeBookSol = "E X # # # # # # # # # #           #   # # # # # # # # #   # # # # # # # # #   # # # # #   #       # # # # #   # # #   # # # # # # # # # # # # # # # # # # # # # #       # # # # # # # # # # # # # # # #";
        mazeIslandSol = "E # # # # # # # # # # X # # # # # #               # # # # #       # #   # # # # #   # # # # # # #   # #           #   # # # # # # #   # #   # # #   # # # # # # # # #   # #   #       #   # # # # # # #   # #   #   # # #   # # # # # # #   # # # #           # # # # # # #   # # # # # # # # # # # # # # # #   # # # # # # # # # # # # # # #     # # # # # # # # # # # # # # # # # #";
        mazeMonsterSol = "E # # # # # # # # # # # # #       #       #       # # # #   #   #   # # #   # # # #   #   # # #   #   # # # # # # # # # # # # # # # # # # # # # # # # # # # #     # # # # # # # # # # #   # # #   # # # # # # # #   #       # # # # #   # #   # # # # # # # # #   # #           #     # # # X # # # # # # # # # # # # #";
    }

    @Test
    public void testSolution() {

        assertEquals("This is a maze with no escape", noEscape1Sol, noEscape1.toString().trim().replaceAll("\n", ""));

        assertEquals("This is a maze with no escape", noEscape2Sol, noEscape2.toString().trim().replaceAll("\n", ""));
       
        assertEquals("You can't scape", mazeBookSol, mazeBook.toString().trim().replaceAll("\n", ""));
       
        assertEquals("You can't scape", mazeIslandSol, mazeIsland.toString().trim().replaceAll("\n", ""));
       
        assertEquals("You can't scape", mazeMonsterSol, mazeMonster.toString().trim().replaceAll("\n", ""));    }

}
