package com.question.controllers;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question){
        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.get();
    }

    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable Long questionId){
        return questionService.getOne(questionId);
    }

    //get All Questions of Specific Quiz
    @GetMapping("/quiz/{quizId}")
    public  List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionsOfQuiz(quizId);
    }
}
