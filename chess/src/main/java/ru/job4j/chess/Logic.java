package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws IllegalStateException {
        boolean rst = false;
        int index = this.findBy(source);
        int target = this.findBy(dest);
        if (index != -1 && target == -1) {
            try {
                Cell[] steps = this.figures[index].way(source, dest);
                if (steps.length > 0 && steps[steps.length - 1].equals(dest) && isWayFree(steps, target)) {
                    rst = true;
                    this.figures[index] = this.figures[index].copy(dest);
                }
            }catch (IllegalStateException ise) {
                System.out.println("Can't move by this way!");
            }
        }
        return rst;
    }

    public boolean isWayFree(Cell[] steps, int target) {
        for (int step = 0; step < steps.length; step++) {
            int empty = findBy(steps[step]);
            if (empty != -1 || target != -1) {
                return false;
            }
        }
        return true;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
