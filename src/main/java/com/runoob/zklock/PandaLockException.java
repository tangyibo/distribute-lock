package com.runoob.zklock;

/**
 * @author 作者 E-mail:ruanjianlxm@sina.com
 * @version 创建时间：2015年9月11日 下午10:55:51 类说明
 */
public class PandaLockException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PandaLockException() {
		super();
	}

	public PandaLockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PandaLockException(String message, Throwable cause) {
		super(message, cause);
	}

	public PandaLockException(String message) {
		super(message);
	}

	public PandaLockException(Throwable cause) {
		super(cause);
	}

}
