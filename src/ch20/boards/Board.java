package ch20.boards;

import java.util.Date;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Board {
	
	private int bno; 
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bdate;
}
