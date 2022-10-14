package hu.ujszaszik.data.mapper

interface BaseMapper<Remote, Local> {
    fun map(remote: Remote): Local
}