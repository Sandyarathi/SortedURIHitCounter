package HC_Sandy036;
import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class SortReducer_Sandy036 extends Reducer<IntWritable,Text,Text,IntWritable> {
   
   
    	 public void reduce(IntWritable key, Text value, Context context) throws IOException, InterruptedException {
    	     

    	      context.write(value, key);
    	    }
        
   }

  
   
    
