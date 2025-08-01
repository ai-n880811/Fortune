package Action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Bean.Fortune;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FortuneAction
 */
@WebServlet("/FortuneAction")
public class FortuneAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FortuneAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
		//typeという名前のボタンから送られたvalueの中身を受け取る
		String type = request.getParameter("type");
		List<Fortune> fortunes = new ArrayList<>();
		
		if(type.equals("love")) {
			
			// 恋愛運の一覧(運勢の種類とメッセージ)
			fortunes.add(new Fortune("大吉", "運命の出会いがあるかも！","red"));
			fortunes.add(new Fortune("中吉", "気になるあの人と距離が縮まる予感","orange"));
			fortunes.add(new Fortune("小吉", "ちょっとした優しさが恋のきっかけに","green"));
			fortunes.add(new Fortune("吉", "心を落ち着けて行動すると◎","blue"));
			fortunes.add(new Fortune("凶", "空回りに注意、焦らずにね","gray"));
			fortunes.add(new Fortune("大凶", "今日は恋愛より自分時間を大切に","black"));

			
		}else if(type.equals("work")){
			
			//仕事運の一覧(運勢の種類とメッセージ)
			fortunes.add(new Fortune("大吉", "努力が報われて評価される日！","red"));
			fortunes.add(new Fortune("中吉", "仕事がスムーズに進みそう","orange"));
			fortunes.add(new Fortune("小吉", "地道な積み重ねが大事な日","green"));
			fortunes.add(new Fortune("吉", "無理せずマイペースがカギ","blue"));
			fortunes.add(new Fortune("凶", "ミスに注意、丁寧に進めよう","gray"));
			fortunes.add(new Fortune("大凶", "今日は静かに過ごすのが無難かも","black"));
		    
		}else {
			
			// 金運の一覧(運勢の種類とメッセージ)
			fortunes.add(new Fortune("大吉", "臨時収入のチャンス！宝くじ買ってみる？","red"));
			fortunes.add(new Fortune("中吉", "ちょっと得することがあるかも","orange"));
			fortunes.add(new Fortune("小吉", "財布のひもは少しゆるめでもOK","green"));
			fortunes.add(new Fortune("吉", "収支バランス良好、穏やかな一日","blue"));
			fortunes.add(new Fortune("凶", "無駄遣いに注意してね","gray"));
			fortunes.add(new Fortune("大凶", "詐欺やトラブルに要注意…","black"));
		}
		
	    
	    // 0～リストサイズ未満の中からランダムで1つ選ぶ
	    int index = new Random().nextInt(fortunes.size());
	    Fortune result = fortunes.get(index);

	    // 選ばれた運勢を表示画面jspに「fortune」という名前で「request」に保存
	    request.setAttribute("fortune", result);

	    // 表示を「result.jsp」に任せる(画面を切り替える/フォワード)
	    RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
	    dispatcher.forward(request, response);
	}


}