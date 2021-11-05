package com.crossaz.common.utils;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class PerfUtil {
    static class BlockInfo{
        String name;
        long callTimes;
        long totalTime;
        long maxTime;
    }
    static ThreadLocal<Map<String, Long>> runInfo = new ThreadLocal<Map<String, Long>>(){
        @Override
        protected  Map<String, Long> initialValue(){
            return new HashMap<>();
        }
    } ;

    static Map<String, BlockInfo> statics = new ConcurrentHashMap<>();

    public static void start(String blockName){
        Map<String, Long> s = runInfo.get();
        s.put(blockName, System.nanoTime());
    }

    public static void clear(){
        statics = new ConcurrentHashMap<>();
    }

    public static void end(String blockName){
        long d = System.nanoTime();
        Map<String, Long> s = runInfo.get();
        long start = s.get(blockName);
        d -= start;
        BlockInfo info = statics.get(blockName);
        if(info == null){
            synchronized (PerfUtil.class){
                info = statics.get(blockName);
                if(info == null){
                    info = new BlockInfo();
                    info.name = blockName; info.callTimes = 0; info.maxTime = 0; info.maxTime =0;
                    statics.put(blockName, info);
                }
            }
        }
        synchronized (info){
            info.callTimes ++;
            info.totalTime += d;
            if(d>info.maxTime) info.maxTime = d;
        }
    }

    public static void log(){
        for(BlockInfo info : statics.values()){
            System.out.println(info.name+":"
                    +"avg("+ (info.totalTime/1000.0/1000.0/info.callTimes)+")"
                    +"total("+ (info.totalTime/1000.0/1000.0)+")"
                    +"max("+ (info.maxTime/1000.0/1000.0)+")"
                    +"calltimes("+ (info.callTimes)+")");
        }
    }
}
