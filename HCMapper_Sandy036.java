package HC_Sandy036;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class HCMapper_Sandy036  extends Mapper<LongWritable, Text, Text, IntWritable> {
      
	private final static IntWritable one = new IntWritable(1);
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String URI= value.toString().substring(value.toString().indexOf('"')+1,value.toString().lastIndexOf('"'));
            String interkey= URI.substring(URI.indexOf('/'));
            context.write(new Text(interkey), one);
            
		
	}
	
	
}
