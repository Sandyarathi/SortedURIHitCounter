package HC_Sandy036;
import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class HCReducer_Sandy036 extends Reducer<Text,IntWritable,Text,IntWritable> {
   
    	 public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
    	      int sum = 0;
    	      for (IntWritable value : values) {
    	        sum += value.get();
    	      }

    	      context.write(key, new IntWritable(sum));
    	    }
        
   }

  
   
    
