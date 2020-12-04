package com.example.gyankunj.di

import com.example.gyankunj.splash.SplashViewModel
import com.example.gyankunj.ui.auth.forgotPassword.ForgotPasswordFinalViewModel
import com.example.gyankunj.ui.auth.forgotPassword.ForgotPasswordViewModel
import com.example.gyankunj.ui.auth.forgotPassword.VerificationViewModel
import com.example.gyankunj.ui.auth.signIn.SignInViewModel
import com.example.gyankunj.ui.auth.signUp.SignUpPasswordViewModel
import com.example.gyankunj.ui.auth.signUp.SignUpVerificationViewModel
import com.example.gyankunj.ui.auth.signUp.SignUpViewModel
import com.example.gyankunj.ui.home.MainViewModel
import com.example.gyankunj.ui.home.mycourse.CourseViewModel
import com.example.gyankunj.ui.home.mycourse.chapter.PhysicsChapterViewModel
import com.example.gyankunj.ui.home.mycourse.chapter.topics.formulas.FormulaViewModel
import com.example.gyankunj.ui.home.mycourse.chapter.topics.info.InfoViewModel
import com.example.gyankunj.ui.home.mycourse.chapter.topics.lessons.LessonsViewModel
import com.example.gyankunj.ui.home.mycourse.chapter.topics.lessons.activity.LessonContentViewModel
import com.example.gyankunj.ui.home.mycourse.chapter.topics.viewModel.TopicOneViewModel
import com.example.gyankunj.ui.home.mycourse.teachersBio.TeachersProfileViewModel
import com.example.gyankunj.ui.home.mycourse.teachersBio.fragment.TeachersBioViewModel
import com.example.gyankunj.ui.home.mycourse.teachersBio.fragment.TeachersCourseViewModel
import com.example.gyankunj.ui.home.noticeBoard.NoticeBoardViewModel
import com.example.gyankunj.ui.home.practiceSet.PracticeSetViewModel
import com.example.gyankunj.ui.home.profile.ProfileViewModel
import com.example.gyankunj.ui.home.quiz.QuizViewModel
import com.example.gyankunj.ui.home.quiz.randomQuiz.RandomQuizViewModel
import com.example.gyankunj.ui.home.settings.SettingsViewModel
import com.example.gyankunj.ui.onBoarding.OnBoardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { SplashViewModel() }
    viewModel { MainViewModel(get(),get(),get()) }
    viewModel { OnBoardingViewModel() }
    viewModel { SignInViewModel(get(),get()) }
    viewModel { ForgotPasswordViewModel(get()) }
    viewModel { VerificationViewModel(get(),get()) }
    viewModel { ForgotPasswordFinalViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { SignUpVerificationViewModel(get(),get()) }
    viewModel { SignUpPasswordViewModel(get()) }
    viewModel { CourseViewModel() }
    viewModel { PhysicsChapterViewModel() }
    viewModel { QuizViewModel() }
    viewModel { RandomQuizViewModel() }
    viewModel { TopicOneViewModel() }
    viewModel { InfoViewModel() }
    viewModel { LessonsViewModel() }
    viewModel { LessonContentViewModel() }
    viewModel { TeachersProfileViewModel() }
    viewModel { TeachersCourseViewModel() }
    viewModel { TeachersBioViewModel() }
    viewModel { FormulaViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { NoticeBoardViewModel() }
    viewModel { PracticeSetViewModel() }
    viewModel { SettingsViewModel() }



}