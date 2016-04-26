package HC_Sandy036;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class HCDriver_Sandy036 extends Configured implements Tool {
   public static void main(String[] args) throws Exception {
      Configuration conf = new Configuration();
      System.exit(ToolRunner.run(conf, new HCDriver_Sandy036(), args));
   }
   
   public int run(String[] args) throws Exception {
      Job job1 = new Job(getConf(), "HitCount");

      job1.setJarByClass(HCDriver_Sandy036.class);

      job1.setMapperClass(HCMapper_Sandy036.class);
      job1.setReducerClass(HCReducer_Sandy036.class);

      job1.setOutputKeyClass(Text.class);
      job1.setOutputValueClass(IntWritable.class);

      job1.setInputFormatClass(TextInputFormat.class);

      FileInputFormat.addInputPath(job1, new Path(args[0]));
      FileOutputFormat.setOutputPath(job1, new Path("/tmp"));

      job1.waitForCompletion(true);

      Job job2 = new Job(getConf(), "Sort");

      job2.setJarByClass(HCDriver_Sandy036.class);

      job2.setMapperClass(SortMapper_Sandy036.class);
      job2.setReducerClass(SortReducer_Sandy036.class);

      job2.setOutputKeyClass(Text.class);
      job2.setOutputValueClass(IntWritable.class);

      job2.setInputFormatClass(KeyValueTextInputFormat.class);

      FileInputFormat.addInputPath(job2, new Path("/tmp/"));
      FileOutputFormat.setOutputPath(job2, new Path(args[1]));

      job2.waitForCompletion(true) ? 0 : 1);
   }
}
