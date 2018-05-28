package com.cv4j.netdiscovery.dsl

import com.cv4j.netdiscovery.core.SpiderEngine
import com.cv4j.netdiscovery.core.queue.Queue
import com.cv4j.proxy.domain.Proxy

/**
 * Created by tony on 2018/5/28.
 */
class SpiderEngineWrapper {

    var queue: Queue? = null

    var port: Int = 8080

    var proxyList:List<Proxy>? = null
}

fun spiderEngine(init: SpiderEngineWrapper.() -> Unit): SpiderEngine {

    val wrap = SpiderEngineWrapper()

    wrap.init()

    return configSpiderEngine(wrap)
}

fun configSpiderEngine(wrap: SpiderEngineWrapper): SpiderEngine {

    val engine = SpiderEngine.create(wrap?.queue)

    engine.proxyList(wrap?.proxyList)

    engine.httpd(wrap.port)

    return engine
}
