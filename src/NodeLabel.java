
/**
 * Enumeration class NodeLabel - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum NodeLabel{
    ZERO  (0),  //calls constructor with value 3
    ONE   (1),  //calls constructor with value 2
    TWO   (2),   //calls constructor with value 1
    THREE (3),
    FOUR  (4),
    FIVE  (5),
    SIX   (6),
    SEVEN (7),
    EIGHT (8),
    NINE  (9),
    TEN   (10),
    ELEVEN(11),
    TWELVE(12),
    THRIRTEEN(13),
    FOURTEEN(14),
    FIFTEEN(15),
    SIXTEEN(16),
    SEVENTEEN(17),
    EIGHTEEN(18),
    NINETEEN(19),
    TWENTY(20),
    TWENTYONE(21),
    TWENTYTWO(22),
    TWENTYTHREE(23),
    TWENTYFOUR(24),
    TWENTYFIVE(25),
    TWENTYSIX(26),
    TWENTYSEVEN(27),
    TWENTYEIGHT(28),
    TWENTYNINE(29)
    ; // semicolon needed when fields / methods follow


    private final int levelCode;

    NodeLabel(int levelCode) {
        this.levelCode = levelCode;
    }
    
    public int getLabelCode() {
        return this.levelCode;
    }
}
