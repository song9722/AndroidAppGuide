package com.limlab.kotlinsample

class MovieKotlin {
    var leadingActors: List<ActorKotlin?>? = null
    var supportActors: List<ActorKotlin?>? = null
    var title: String? = null
    var showingAge: Int = 0
    var genre: String? = null


    class ActorKotlin{
        var realName: String? = null
        var stageName: String? = null
        var age: Int = 0
        var gender: String? = null
        var actedMovie: List<MovieKotlin?>? = null
    }

    fun casting(movies: List<MovieKotlin?>?): MutableList<ActorKotlin> {
        var recommendActors = mutableListOf<ActorKotlin>()
        movies?.forEach{ movie ->
            if (movie?.title?.contains("도시") == true) {
                movie.leadingActors?.filter {
                    it?.gender == "W" && it.age in 20..30 && (it.actedMovie?.size ?: 0) > 5
                }?.forEach { it?.let{recommendActors.add(it)} }

                movie.supportActors?.filter {
                    it?.gender == "M" && it.age in 30..40 && it.actedMovie?.filter{ it?.genre == "공포" }?.size ?: 0 > 3
                }?.forEach { it?.let { recommendActors.add(it) } }
            }
        }
        return recommendActors
    }
}