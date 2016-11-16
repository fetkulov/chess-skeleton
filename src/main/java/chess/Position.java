package chess;

import org.apache.commons.lang.builder.*;

/**
 * Describes a position on the Chess Board
 */
public class Position {
    public static final int A_POSITION = (int)'a';
    public static final int MIN_ROW = 0;
    public static final int MAX_ROW = 7;
    public static final int MIN_COLUMN = 0;
    public static final int MAX_COLUMN = 7;
    public static final char MIN_COLUMN_VALUE = 'a';
    public static final char MAX_COLUMN_VALUE = 'h';

    private int row;
    private int column;

    /**
     * Create a new position object
     *
     * @param column The column
     * @param row The row
     */
    public Position(int column, int row){

        if (isOutOfBoard(column, row)) {
            throw new IllegalArgumentException("Incorrect position!");
        }

        this.row = row;
        this.column = column;
    }


    public static boolean isOutOfBoard(int column, int row) {
        if( row > MAX_ROW || row < MIN_ROW|| column > MAX_COLUMN || column < MIN_COLUMN){
            return true;
        }
        return false;
    }

    /**
     * Create a new Position object by parsing the string
     * @param colrow The column and row to use.  I.e. "a1", "h7", etc.
     */
    public Position(String colrow) {
        this((int) (colrow.toCharArray()[0]) - A_POSITION, colrow.toCharArray()[1] - '1');
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getRowName() {
        return (char) (row + 1);
    }

    public String getColumnRow(){
        return new StringBuilder().append((char) (column + A_POSITION)).append(row + 1).toString();
    }

    public char getColumnName() {
        return (char) (column + A_POSITION);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position == false) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        final Position otherObject = (Position) obj;

        return new EqualsBuilder()
                .append(this.column, otherObject.column)
                .append(this.row, otherObject.row)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.row)
                .append(this.column)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("row:", this.row)
                .append(" column:", this.column)
                .toString();
    }

}
