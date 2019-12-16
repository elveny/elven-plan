package site.elven.plan.web.base.response;

@FunctionalInterface
public interface IResponseParser<ORIGIN,TARGET> {
    /**
     * 对象转换器
     *
     * @param origin
     * @return
     */
    TARGET parse(ORIGIN origin);
}