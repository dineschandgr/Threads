package io.java.threads;

public class DownloadStatus {
	private boolean isDone;
	private int totalBytes;
	private int totalFiles;
	private Object totalBytesLock = new Object();
	private Object totalFilesLock = new Object();

	public int getTotalBytes() {
		return totalBytes;
	}
	
	public synchronized int getTotalFiles() {
		return totalFiles;
	}

	public boolean isDone() {
		return isDone;
	}

	public void done() {
		isDone = true;
	}

	public synchronized void incrementTotalBytes(){
		synchronized (totalBytesLock) {
			totalBytes++;
		}
	}
	
	public void incrementTotalFiles(){
		synchronized (totalFilesLock) {
			totalBytes++;
		}
	}
}