import { useState } from "react";

function TodoItem({checked, title, description}) {
    let classes = "flex-1 text-gray-500";

    const [isChecked, setChecked] = useState(checked);

    if (isChecked) {
        classes = classes += " line-through"
    }

    return (
        <li className="p-4 flex items-center gap-3 hover:bg-gray-50">
            <input type="checkbox" checked={isChecked} className="h-5 w-5 rounded border-gray-300 text-purple-600 focus:ring-purple-500" onClick={(e) => setChecked(!isChecked)}/>
                <span className={classes}>{title}</span>
                <button className="text-red-500 hover:text-red-700">
                    <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                    </svg>
                </button>
        </li>
    );
}

export default TodoItem;