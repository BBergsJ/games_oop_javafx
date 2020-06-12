package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest extends TestCase {

    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell expected = bishopBlack.position();
        assertThat(bishopBlack.toString(), is(expected.toString()));
    }

    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure expected = bishopBlack.copy(Cell.G5);
//        assertThat(expected.toString(), is("G5"));
        Assert.assertEquals(expected.toString(), "G5");
    }

    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = bishopBlack.way(Cell.C1, Cell.G5);
        assertThat(expected, is(new Cell[] {Cell.D2, Cell.E3,Cell.F4, Cell.G5}));
    }

    public void testWayWhenDownLeftThen() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] expected = bishopBlack.way(Cell.D4, Cell.G1);
        assertThat(expected, is(new Cell[] {Cell.E3, Cell.F2,Cell.G1}));
    }
}