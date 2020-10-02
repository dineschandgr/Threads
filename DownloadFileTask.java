package Threads;

import java.util.ArrayList;
import java.util.List;

public class DownloadFileTask implements Runnable{
	private DownloadStatus status;
	public DownloadFileTask() {
		this.status = new DownloadStatus();
	}
	@Override
	public void run() {
		System.out.println("Download File Task "+Thread.currentThread().getName());
			for(int i = 0; i < 10_000 ; i++){
				if(Thread.currentThread().isInterrupted())
					return;
				status.incrementTotalBytes();
			}
		
		System.out.println("download completed "+Thread.currentThread().getName());
	}

}

class DownloadFileTask1 implements Runnable{
	List<Integer> list = Services1.getNum();
	@Override
	public void run() {
		System.out.println("Download File Task1 "+Thread.currentThread().getName());
			for(int i = 0; i < 10; i++){
				System.out.println("Downloading byte1 "+i);
				list.add(i);
			}
		System.out.println(list.size());
		
		System.out.println("download completed1 "+Thread.currentThread().getName());
	}

}

abstract class Services1
{

    static List<Integer> list = new ArrayList<Integer>();

    static
    {
    for (int i = 0; i < 20; i++)
    {
        list.add(i);
    }
    }

    static public List<Integer> getNum()
    {
    return list;
    }

}
