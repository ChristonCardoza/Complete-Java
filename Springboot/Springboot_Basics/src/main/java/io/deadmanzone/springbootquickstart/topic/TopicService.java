package io.deadmanzone.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepositoy;
	
//	private List<Topic> topics =  new ArrayList<>(Arrays.asList(
//			new Topic("spring", "Spring Framework", "Spring Framework Description"),
//			new Topic("java", "Core java", "Core java Description"),
//			new Topic("javascript", "JavaScript", "Javascript Description")
//			));
	
	public List<Topic> getAllTopics(){
//		return topics;
		
		List<Topic> topics = new ArrayList<>();
		topicRepositoy.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return topicRepositoy.findOne(id);
	}
	
	public void addTopic(Topic topic) {
//		topics.add(topic);
		
		topicRepositoy.save(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
//		for(int i=0; i<topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		
		topicRepositoy.save(topic);
		
	}
	
	public void deleteTopic(String id) {
//		topics.removeIf((t -> t.getId().equals(id)));
		
		topicRepositoy.delete(id);
	}
}
