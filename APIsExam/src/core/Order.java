package core;

import java.time.LocalDateTime;

public class Order implements Comparable<Order>{


	private LocalDateTime readyOn;
	private String text;
	private boolean important;
	private boolean poped;

	public Order(LocalDateTime readyOn, String text, boolean important) {
		super();
		this.readyOn = readyOn;
		this.text = text;
		this.important = important;
	}
	
	public LocalDateTime getReadyOn() {
		return readyOn;
	}
	
	public void setReadyOn(LocalDateTime readyOn) {
		this.readyOn = readyOn;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public boolean isImportant() {
		return important;
	}
	
	public void setImportant(boolean important) {
		this.important = important;
	}
	
	public boolean isPoped() {
		return poped;
	}
	
	public void setPoped(boolean poped) {
		this.poped = poped;
	}
	
	
	@Override
	public String toString() {
		return "Order [readyOn=" + readyOn + ", text=" + text + ", important=" + important + ", poped=" + poped + "]";
	}
	
	

	@Override
	public int compareTo(Order other) {
		if (this.equals(other)) {
			return 0;
		}
		return this.readyOn.compareTo(other.readyOn);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((readyOn == null) ? 0 : readyOn.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (readyOn == null) {
			if (other.readyOn != null)
				return false;
		} else if (!readyOn.equals(other.readyOn))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
