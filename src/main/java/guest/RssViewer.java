package guest;

import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Item;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RssViewer extends AbstractRssFeedView {
    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Channel feed, HttpServletRequest request) {
        feed.setTitle("ToDoList");
        feed.setDescription("ITMO University project from chair of Computer Educational Technologies");
        feed.setLink("http://www.ifmo.ru/ru/");
        super.buildFeedMetadata(model, feed, request);
    }

    @Override
    protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        @SuppressWarnings("unchecked")
        List<Task> listContent = (List<Task>) model.get("feedContent");
        List<Item> items = new ArrayList<Item>(listContent.size());

        for(Task tempContent : listContent ){

            Item item = new Item();

            Content content = new Content();
            content.setValue(tempContent.getText());
            item.setContent(content);

            item.setAuthor(tempContent.getUserName());
            item.setPubDate(tempContent.getDate());

            items.add(item);
        }

        return items;
    }
}
