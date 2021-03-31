
import java.util.*;

public class SetOfLabels{

    private EnumSet < NodeLabel > es = EnumSet.noneOf(NodeLabel.class);
    private int maxCardinality;
    private int nOfElements = 0;

    public SetOfLabels(int x, int maxCardinality)
    {
        this.maxCardinality = maxCardinality;
        int mask = 1;
        for(int i = 0;i < maxCardinality;i++) {
            if ((x & mask) != 0) {
                    es.add(NodeLabel.values()[i]);
                    nOfElements++;
            }
            mask = mask*2;
        }
    }
    
    public EnumSet < NodeLabel > getNodeLabels() {
        return es;
    }
    
    public boolean contains(NodeLabel nl) {
        return es.contains(nl);
    }
    
    public int getNumberOfElements() {
        return nOfElements;
    }
    
    public String toString() {
        String result = "[";
        for( NodeLabel n : es ) {
            result = result+" "+n.toString();
        }
        result = result+" ]";
        return result;
    }
        
    
    public static SetOfLabels min(SetOfLabels a,SetOfLabels b) {
        return a.nOfElements < b.nOfElements ? a : b;
    }
    
     
    
}
