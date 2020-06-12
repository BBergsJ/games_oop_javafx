package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.lang.Math;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(String.format("Could not move by diagonal from %s to %s", source, dest));
        }
        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
//        int deltaX = dest.x > source.x ? 1 : -1;
//        int deltaY = dest.y > source.y ? 1 : -1;
        int deltaX = 0;
        int deltaY = 0;
        if ( dest.x > source.x) {
            deltaX = 1;
            deltaY = 1;
        } else if (dest.x < source.x){
            deltaX = -1;
            deltaY = -1;
        }
        for (int i = 0; i < size; i++) {
            int x = source.x + deltaX + i;
            int y = source.y + deltaY + i;
            steps[i] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (Math.abs(source.x - dest.x) != Math.abs(source.y - dest.y)) {
            return false;
        }
        return true;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    @Override
    public String toString() {
        return position.toString();
    }
}

