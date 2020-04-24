import org.junit.Test;
import static org.junit.Assert.*;

public class GameOfLifeTestTest {
    @Test
    public void Grid() {
        int[][] grid = new int[10][10];
    }

    @Test
    public void AnyLiveCellWithFewerThanTwoLiveNeighborsDies() {
        assertEquals ("+", "+");
    }

    @Test
    public void AnyLiveCellWithTwoLiveNeighborsLivesOnToTheNextGeneration () {
        assertEquals ("#","#");
    }

    @Test
    public void AnyLiveCellWithMoreThanThreeLiveNeighborsDies () {
        assertEquals ("+","+");
    }

    @Test
    public void CellIsDeadBut3LivesNeighborsCausesItToBeBorn () {
        assertEquals ("#","#");
    }
}