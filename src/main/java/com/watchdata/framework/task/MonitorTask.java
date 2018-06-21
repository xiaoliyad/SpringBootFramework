package com.watchdata.framework.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.watchdata.framework.id.SnowflakeIdWorker;

@Component
public class MonitorTask {
	private final static Logger log=Logger.getLogger(MonitorTask.class);
//	@Autowired
//	CacheManager cacheManager;
	SnowflakeIdWorker snowflakeIdWorker;
//	字段 允许值 允许的特殊字符 
//	秒 0-59 , - * / 
//	分 0-59 , - * / 
//	小时 0-23 , - * / 
//	日期 1-31 , - * ? / L W C 
//	月份 1-12 或者 JAN-DEC , - * / 
//	星期 1-7 或者 SUN-SAT , - * ? / L C # 
//	年（可选） 留空, 1970-2099 , - * / 
//	表达式 意义 
//	"0 0 12 * * ?" 每天中午12点触发 
//	"0 15 10 ? * *" 每天上午10:15触发 
//	"0 15 10 * * ?" 每天上午10:15触发 
//	"0 15 10 * * ? *" 每天上午10:15触发 
//	"0 15 10 * * ? 2005" 2005年的每天上午10:15触发 
//	"0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发 
//	"0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发 
//	"0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发 
//	"0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发 
//	"0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发 
//	"0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发 
//	"0 15 10 15 * ?" 每月15日上午10:15触发 
//	"0 15 10 L * ?" 每月最后一日的上午10:15触发 
//	"0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发 
//	"0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发 
//	"0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发 
//	特殊字符 意义 
//	* 表示所有值； 
//	? 表示未说明的值，即不关心它为何值； 
//	- 表示一个指定的范围； 
//	, 表示附加一个可能值； 
//	/ 符号前表示开始时间，符号后表示每次递增的值；
//	Cron表达式范例
//	每隔5秒执行一次：*/5 * * * * ?
//	每隔1分钟执行一次：0 */1 * * * ?
//	每天23点执行一次：0 0 23 * * ?
//	每天凌晨1点执行一次：0 0 1 * * ?
//	每月1号凌晨1点执行一次：0 0 1 1 * ?
//	每月最后一天23点执行一次：0 0 23 L * ?
//	每周星期天凌晨1点实行一次：0 0 1 ? * L
//	在26分、29分、33分执行一次：0 26,29,33 * * * ?
//	每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?
//	每隔5分钟执行一次：0 0/5 * * * ?
	@Scheduled(cron="0/1 * * * * ?")
	public void watchOnCache(){
//		snowflakeIdWorker=new SnowflakeIdWorker(0, 0);
//		System.out.println(snowflakeIdWorker.nextId());
//		System.out.println(Long.toBinaryString(snowflakeIdWorker.nextId()));
//		String[] cacheNames=cacheManager.getCacheNames();
//		log.debug("[CACHE WATCHER START==================================]");
//		
//		for (String cacheName : cacheNames) {
//			Cache cache=cacheManager.getCache(cacheName);
//			log.debug(cache.getName());
//			log.debug(cache.toString());
//			List<?> cacheList=cache.getKeys();
//			for (Object key : cacheList) {
//				log.debug("key:"+key+"|value:"+cache.get(key));
//			}
//		}
//		log.debug("[CACHE WATCHER END======================================]");
//		log.debug("\u738B\u80D6\u5B50\u63D0\u8D77\u51B2\u950B\u67AA\uFF0C\u55D2\u55D2\u55D2\u55D2...\u4E00\u68AD\u5B50\u5B50\u5F39\u90FD\u62DB\u547C\u5728\u5927\u7CBD\u5B50\u7684\u8EAB\u4E0A\u3002");
	}
}
